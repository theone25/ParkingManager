package com.parkingmanager.services;

import com.parkingmanager.App;
import com.parkingmanager.controllers.camerastreamController;
import com.parkingmanager.models.Voiture;
import com.parkingmanager.models.query.QPlace;
import com.parkingmanager.models.query.QVoiture;
import io.ebean.DB;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.sourceforge.tess4j.Tesseract;
import nu.pattern.OpenCV;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.dnn.Dnn;
import org.opencv.dnn.Net;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.osgi.OpenCVInterface;
import org.opencv.utils.Converters;
import org.opencv.video.Video;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import com.parkingmanager.models.Voiture;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class opencvvideofeed extends Thread {
    private static final String[] classNames = {"license_plate"};
    public static ImageView imgview=new ImageView();

    private VideoCapture capture;
    Tesseract instance = new Tesseract();
    int countcheck=0;


    public opencvvideofeed() {
        instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
        instance.setLanguage("eng");
        this.capture = new VideoCapture(0);
        imgview=new ImageView();
        imgview.setFitHeight(377);
        imgview.setFitWidth(670);

    }
    @Override
    public void run() {
        Mat frame=new Mat();
        while(capture.read(frame)){
            try {
                imgview.setImage(convertToImageView(onCameraFrame(frame)));
                camerastreamController.camstream.setImage(convertToImageView(onCameraFrame(frame)));
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    /*private static void detectAndDraw(Mat image) {//detect faces and draw a blue rectangle arroung each face

        Imgproc.resize(image, image, new Size(416, 416));//resize the image to match the input size of the model

        //create a 4-dimensional blob from image with NCHW (Number of images in the batch -for training only-, Channel, Height, Width) dimensions order,
        //for more detailes read the official docs at https://docs.opencv.org/trunk/d6/d0f/group__dnn.html#gabd0e76da3c6ad15c08b01ef21ad55dd8
        Mat blob = Dnn.blobFromImage(image, 1.0, new Size(300, 300), new Scalar(104.0, 177.0, 123.0, 0), false, false, CvType.CV_32F);

        App.net.setInput(blob);//set the input to network model
        Mat output = App.net.forward();//feed forward the input to the netwrok to get the output matrix

        Mat ne = new Mat(new Size(output.size(3), output.size(2)), CvType.CV_32F, output.ptr(0, 0));//extract a 2d matrix for 4d output matrix with form of (number of detections x 7)

        FloatIndexer srcIndexer = ne.createIndexer(); // create indexer to access elements of the matric

        for (int i = 0; i < output.size(3); i++) {//iterate to extract elements
            float confidence = srcIndexer.get(i, 2);
            float f1 = srcIndexer.get(i, 3);
            float f2 = srcIndexer.get(i, 4);
            float f3 = srcIndexer.get(i, 5);
            float f4 = srcIndexer.get(i, 6);
            if (confidence > .6) {
                float tx = f1 * 300;//top left point's x
                float ty = f2 * 300;//top left point's y
                float bx = f3 * 300;//bottom right point's x
                float by = f4 * 300;//bottom right point's y
                rectangle(image, new Rect(new Point((int) tx, (int) ty), new Point((int) bx, (int) by)), new Scalar(255, 0, 0, 0));//print blue rectangle
            }
        }
    }*/

    private Mat getFrame(Mat frame){
        final int IN_WIDTH = 720;
        final int IN_HEIGHT = 720;
        final double IN_SCALE_FACTOR = 0.007843;
        final double MEAN_VAL = 0.76;
        final double THRESHOLD = 0.3;


        double fps = capture.get(Videoio.CAP_PROP_FPS);
        System.out.println(fps);
        //convertToImageView(frame);
        Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGBA2RGB);
        // Forward image through network.
        Mat blob = Dnn.blobFromImage(frame, IN_SCALE_FACTOR,new Size(IN_WIDTH, IN_HEIGHT),new Scalar(MEAN_VAL, MEAN_VAL, MEAN_VAL), /*swapRB*/false, /*crop*/false);
        App.net.setInput(blob);
        Mat detections = App.net.forward();
        int cols = frame.cols();
        int rows = frame.rows();
        System.out.println(detections.total());
        detections = detections.reshape(1, (int)detections.total() / 9);
        for (int i = 0; i < detections.rows(); ++i) {
            double confidence = detections.get(i, 2)[0];
            if (confidence > THRESHOLD) {
                int classId = (int)detections.get(i, 1)[0];
                int left   = (int)(detections.get(i, 3)[0] * cols);
                int top    = (int)(detections.get(i, 4)[0] * rows);
                int right  = (int)(detections.get(i, 5)[0] * cols);
                int bottom = (int)(detections.get(i, 6)[0] * rows);
                // Draw rectangle around detected object.
                Imgproc.rectangle(frame, new Point(left, top), new Point(right, bottom),
                        new Scalar(0, 255, 0));
                String label = classNames[classId] + ": " + confidence;
                int[] baseLine = new int[1];
                Size labelSize = Imgproc.getTextSize(label, Imgproc.FONT_HERSHEY_SIMPLEX, 0.5, 1, baseLine);
                // Draw background for label.
                Imgproc.rectangle(frame, new Point(left, top - labelSize.height),
                        new Point(left + labelSize.width, top + baseLine[0]),
                        new Scalar(255, 255, 255), Imgproc.FILLED);
                // Write class name and confidence.
                Imgproc.putText(frame, label, new Point(left, top),Imgproc.FONT_HERSHEY_SIMPLEX, 0.5, new Scalar(0, 0, 0));
            }
        }
        return frame;
    }

    private Image convertToImageView(Mat frame){
        MatOfByte buffer = new MatOfByte();
        Imgcodecs.imencode(".png", frame, buffer);
        //Image imageToShow = new Image(new ByteArrayInputStream(buffer.toArray()));

        return new Image(new ByteArrayInputStream(buffer.toArray()));
    }


    public Mat onCameraFrame(Mat frame) {
        Mat ROI =frame;
        Mat gray=frame;
        String mat="";
        String matcheck="";
        Process mProcess;
        Imgproc.cvtColor(frame, frame, Imgproc.COLOR_RGBA2RGB);
        Mat imageBlob = Dnn.blobFromImage(frame, 0.00392, new Size(416,416),new Scalar(0, 0, 0),/*swapRB*/false, /*crop*/false);
        App.net.setInput(imageBlob);
        ArrayList<Mat> result = new java.util.ArrayList<Mat>(2);
        ArrayList<String> outBlobNames = new ArrayList<String>();
        //yolov3
        outBlobNames.add(0, "yolo_82");
        outBlobNames.add(1, "yolo_94");
        outBlobNames.add(2, "yolo_106");
        //yolov4
        //outBlobNames.add(0, "yolo_139");
        //outBlobNames.add(1, "yolo_150");
        //outBlobNames.add(2, "yolo_161");
        App.net.forward(result,outBlobNames);
        float confThreshold = 0.3f;
        ArrayList<Integer> clsIds = new ArrayList<>();
        ArrayList<Float> confs = new ArrayList<Float>();
        ArrayList<Rect2d> rects = new ArrayList<Rect2d>();
        for (int i = 0; i < result.size(); ++i)
        {
            Mat level = result.get(i);
            for (int j = 0; j < level.rows(); ++j)
            {
                Mat row = level.row(j);
                Mat scores = row.colRange(5, level.cols());
                Core.MinMaxLocResult mm = Core.minMaxLoc(scores);
                float confidence = (float)mm.maxVal;
                Point classIdPoint = mm.maxLoc;
                if (confidence > confThreshold)
                {
                    int centerX = (int)(row.get(0,0)[0] * frame.cols());
                    int centerY = (int)(row.get(0,1)[0] * frame.rows());
                    int width   = (int)(row.get(0,2)[0] * frame.cols());
                    int height  = (int)(row.get(0,3)[0] * frame.rows());
                    int left    = centerX - width  / 2;
                    int top     = centerY - height / 2;
                    clsIds.add((int)classIdPoint.x);
                    confs.add((float)confidence);
                    rects.add(new Rect2d(left, top, width, height));
                }
            }
        }
        int ArrayLength = confs.size();
        if (ArrayLength>=1) {
            // Apply non-maximum suppression procedure.
            float nmsThresh = 0.2f;
            MatOfFloat confidences = new MatOfFloat(Converters.vector_float_to_Mat(confs));
            Rect2d[] boxesArray = rects.toArray(new Rect2d[0]);
            MatOfRect2d boxes = new MatOfRect2d(boxesArray);
            MatOfInt indices = new MatOfInt();
            Dnn.NMSBoxes(boxes, confidences, confThreshold, nmsThresh, indices);
            // Draw result boxes:
            int[] ind = indices.toArray();
            //Arrays.stream(new File("C:\\Users\\moham\\Documents\\GitHub\\ParkingManager\\src\\main\\resources\\com\\parkingmanager\\images\\ocr\\").listFiles()).forEach(File::delete);
            for (int i = 0; i < ind.length; ++i) {
                int idx = ind[i];
                Rect2d box = boxesArray[idx];
                int idGuy = clsIds.get(idx);
                float conf = confs.get(idx);
                ArrayList<String> cocoNames = new ArrayList<String>();
                cocoNames.add("license_plate");
                int intConf = (int) (conf * 100);
                Imgproc.putText(frame, cocoNames.get(idGuy) + " " + intConf + "%", box.tl(), Imgproc.FONT_HERSHEY_SIMPLEX, 1, new Scalar(255, 255, 0), 2);
                //Imgproc.rectangle(frame, box.tl(), box.br(), new Scalar(255, 0, 0), 2);
                if (intConf > 0.90) {

                    //crop image for tesseract
                    try {
                        ROI = frame.submat((int) Math.round(box.y-5), (int) Math.round(box.y + box.height+5), (int) Math.round(box.x-5), (int) Math.round(box.x + box.width+5));
                        //resize image to 3 times big
                        Imgproc.resize(ROI, ROI, new Size(), 3, 3, Imgproc.INTER_CUBIC);
                        String path = new File("").getAbsolutePath();
                        Imgcodecs.imwrite(path+File.separator +"src"+File.separator +"main"+File.separator +"resources"+File.separator +"com"+File.separator +"parkingmanager"+File.separator +"images"+File.separator +"ocr"+File.separator+ "plate" + ".jpg", ROI);

                        //this part processes data from licence plate image and returns licence plate number
                        //it is slow and innacurate, so i am using a different method that calls and recieves output from a python file
                        //it is the same code but using different library( tess4j on java, and pytesseract on python)

                        /*gray = ROI;
                        Imgproc.cvtColor(ROI, ROI, Imgproc.COLOR_RGB2GRAY);
                        Imgproc.GaussianBlur(ROI, ROI, new Size(15, 15), 0);
                        Imgproc.threshold(ROI, ROI, 0, 255, Imgproc.THRESH_OTSU | Imgproc.THRESH_BINARY_INV);
                        Mat thresh = new Mat();
                        Imgproc.threshold(ROI, thresh, 0, 255, Imgproc.THRESH_OTSU | Imgproc.THRESH_BINARY_INV);
                        Mat rect_ker = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
                        Imgproc.dilate(ROI, ROI, rect_ker, new Point(-1, -1), 1);
                        List<MatOfPoint> contours = new ArrayList<>();
                        Mat hierarchey = new Mat();
                        Imgproc.findContours(ROI, contours, hierarchey, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);

                        List<MatOfPoint> newC = new ArrayList<>();
                        for (int j = contours.size() - 1; j >= 0; j--) {
                            newC.add(contours.get(j));
                        }
                        //Collections.sort(contours,Collections.reverseOrder());
                        List<Mat> chars = new ArrayList<Mat>();
                        int count = 0;
                        for (MatOfPoint m : newC) {

                            int x = Imgproc.boundingRect(m).x;
                            int y = Imgproc.boundingRect(m).y;
                            int w = Imgproc.boundingRect(m).width;
                            int h = Imgproc.boundingRect(m).height;
                            int height = gray.height();
                            int width = gray.width();
                            // if height of box is not tall enough relative to total height then skip
                            if (height / (float) h > 6) {
                                continue;
                            }
                            float ratio = h / (float) w;
                            // if height to width ratio is less than 1.5 skip
                            if (ratio < 1.5) {
                                continue;
                            }
                            // if width is not wide enough relative to total width then skip
                            if (width / (float) w > 15) {
                                continue;
                            }
                            float area = h * w;
                            // if area is less than 100 pixels skip
                            if (area < 100) {
                                continue;
                            }
                            // draw the rectangle
                            Imgproc.rectangle(gray, new Point(x, y), new Point(x + w, y + h), new Scalar(255, 0, 0), 2);
                            // grab character region of image
                            Mat charr = thresh.submat(y - 5, y + h + 5, x - 5, x + w + 5);
                            //thresh = thresh.rowRange(x-5,x+w+5).colRange(y-5,y+h+5);
                            // perfrom bitwise not to flip image to black text on white background
                            //Core.bitwise_not(charr, charr);
                            // perform another blur on character region
                            Imgproc.medianBlur(charr, charr, 5);
                            chars.add(charr);
                            Imgcodecs.imwrite("C:\\Users\\moham\\Documents\\GitHub\\ParkingManager\\src\\main\\resources\\com\\parkingmanager\\images\\ocr\\" + count + ".TIFF", charr);
                            count++;
                        }
                        mat = "";
                        for (Mat m : chars) {
                            instance.setPageSegMode(10);
                            instance.setOcrEngineMode(3);
                            instance.setVariable("tessedit_char_whitelist", "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                            mat = mat + instance.doOCR(Mat2BufferedImage(m)).replaceAll("\\r|\\n", "");
                        }*/


                    } catch (Exception e) {

                    }
                    //this part of code runs the python script that decodes the image and return licence plate number

                    try {
                        String line = runPyScript();
                        Calendar cal = Calendar.getInstance();
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                        if( line!=""){
                            Voiture datevv= new QVoiture().where().matricule.eq(line).orderBy().id_voiture.desc().findOne();
                            if(datevv==null){
                                Voiture v=new Voiture();
                                v.setMatricule(line);
                                v.setDate_entree(formatter.format(cal.getTime()));
                                int plc= new QPlace().where().libre.eq(true).findList().get(0).getId_place();
                                v.setPlace(plc);
                                v.save();
                                new QPlace()
                                        .id_place.eq(plc)
                                        .asUpdate()                      // convert to UpdateQuery
                                        .set("libre", false)        // update set ...
                                        .update();
                            }
                            else{
                                Date d=formatter.parse(datevv.Date_entree);
                                calendar.setTime(d);

                                long diffInMillies = Math.abs(calendar.getTimeInMillis() - cal.getTimeInMillis());
                                System.out.println(diffInMillies);
                                diffInMillies=diffInMillies/1000;
                                diffInMillies=diffInMillies/60;
                                if(diffInMillies>1){
                                    Voiture v=new Voiture();
                                    v.setMatricule(line);
                                    v.setDate_entree(formatter.format(cal.getTime()));
                                    int plc= new QPlace().where().libre.eq(true).findOne().getId_place();
                                    v.setPlace(plc);
                                    v.save();
                                }
                            }


                        }
                    } catch (IOException | ParseException e) {
                        e.printStackTrace();
                    }


                }

            }
        }

        return frame;
    }

    static BufferedImage Mat2BufferedImage(Mat matrix)throws Exception {
        MatOfByte mob=new MatOfByte();
        Imgcodecs.imencode(".jpg", matrix, mob);
        byte[] ba =mob.toArray();

        BufferedImage bi= ImageIO.read(new ByteArrayInputStream(ba));
        return bi;
    }


    public void stopfeed(){
        capture.release();
    }

    public String runPyScript() throws ExecuteException, IOException {
        String path = new File("").getAbsolutePath();
        String line = "python " + path+File.separator+"main.py";
        CommandLine cmdLine = CommandLine.parse(line);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(streamHandler);

        int exitCode = executor.execute(cmdLine);
        return outputStream.toString();
    }


}
