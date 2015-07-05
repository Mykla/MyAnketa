package myAnketaPackage;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;
import java.util.Enumeration;

/**
 * Created by user on 29.06.2015.
 */
public class MyAnketa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // устанаваливаем MIME ответа "text/html"
        resp.setContentType("text/html");

        // используем PrinterWriter для отправки данных клиенту
        // обратившегося к сервлету
        PrintWriter out = resp.getWriter();

        // Начало формирования HTML-содержимого
        out.println("<html><head>");
        out.println("<title>Help page</title></head><body>");
        out.println("<h2>Please submit your information</h2>");

        // метод = "post" поскольку метод сервлета service()
        // вызывает doPost для обработки данных введенных в форму
        out.println("<form method=\"post\" action =\"" + req.getContextPath() + "/myanketa\" >");

        out.println("<table border=\"0\"><tr><td valign=\"top\">");
        out.println("Your first name: </td>  <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"firstname\" size=\"20\">");

        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("Your last name: </td>  <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"lastname\" size=\"20\">");

        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("Your age: </td>  <td valign=\"top\">");
        out.println("<input type=\"text\" name=\"age\" size=\"20\">");

        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("Do You do homework?: </td>  <td valign=\"top\">");
        out.println("<input type=\"radio\" name=\"homeWorkQuestion\" value=\"yes\">" + "Yes" + "<br>");
        out.println("<input type=\"radio\" name=\"homeWorkQuestion\" value=\"no\">" + "No" + "<br>");

        out.println("</td></tr><tr><td valign=\"top\">");
        out.println("What IDE do You use?: </td>  <td valign=\"top\">");
        out.println("<input type=\"radio\" name=\"myIDE\" value=\"eclipse\">" + "Eclipse" + "<br>");
        out.println("<input type=\"radio\" name=\"myIDE\" value=\"intellijIdea\">" + "Intellij IDEA" + "<br>");
        out.println("<input type=\"radio\" name=\"myIDE\" value=\"other\">" + "Other" + "<br>");

        out.println("</td></tr><tr><td valign=\"top\">");

        out.println("<input type=\"submit\" value=\"Submit Info\"></td></tr>");
        out.println("</table></form>");
        out.println("</body></html>");

    } //end doGet

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // отображаем имена изначения параметров
        Enumeration paramNames = req.getParameterNames();

        String parName; // здесь храниться имя параметра

        boolean emptyEnum = false;
        if (!paramNames.hasMoreElements()){
            emptyEnum = true;
        }

        // устанаваливаем MIME ответа "text/html"
        resp.setContentType("text/html");

        // используем PrinterWriter для отправки данных клиенту
        PrintWriter out = resp.getWriter();


        // начало формиования HTML содержимого
        out.println("<html><head>");
        out.println("<title>Submitted Parameters</title></head><body>");

        if (emptyEnum){
            out.println("<h2>Sorry, the request does not contain any parameters</h2>");
        } else {
            out.println("<h2>Here are the submitted parameter values</h2>");
        }

        while(paramNames.hasMoreElements()){

            parName = (String) paramNames.nextElement();
            out.println("<strong>" + parName + "</strong> : " + req.getParameter(parName));
            out.println("<br />");
        }//while

        out.println("</body></html>");
    } // end of doPost
}
