import algorithm.SymmetryAnalyser;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*50, // 2MB
                maxFileSize=1024*1024*50,      // 10MB
                maxRequestSize=1024*1024*50)   // 50MB
public class FileUploadServlet extends HttpServlet {
    /**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";
    private static final String OUTPUT_DIR = "outputFiles";

    /**
     * handles file upload
     */
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        String outputPath = appPath + File.separator + OUTPUT_DIR;

        File fileSaveDir1 = new File(outputPath);
        if (!fileSaveDir1.exists()) {
            fileSaveDir1.mkdir();
        }

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        String fileName = "";
        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName); //writing the file into the created file path
        }

        //access the newly uploaded file
        String fileToRead = savePath + File.separator + fileName;
        File file = new File(fileToRead);

        //apply algorithm to test symmetry, returns an object
        HashMap <String, String> dataToProcess = SymmetryAnalyser.analyseSymmetry(file, outputPath);

        request.setAttribute("file", dataToProcess);
        getServletContext().getRequestDispatcher("/message.jsp").forward(
                request, response);



    }
    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}







