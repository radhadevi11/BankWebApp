package bank;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import bankaccount.BankAccount;
import bankaccount.Customer;
@WebServlet("/bank")
public class BankServlet extends HttpServlet {
    Customer customer = new Customer("Radha","aaa","25365987");
    BankAccount myAccount = new BankAccount(25365,customer);
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        String depositAmount = request.getParameter("amount");
        String withdrawAmount = request.getParameter("amount");
        PrintWriter webWriter = response.getWriter();
        myAccount.deposit((Double.parseDouble(depositAmount)));
        webWriter.println("<html>");
        webWriter.println("<body>");
        webWriter.println("<h1>Mobile Bank </h1>");
        webWriter.println("<h2>The amount deposited successFully!!!</h2> ");
        webWriter.println("<h2>current balance is"+myAccount.getBalance()+"</h2>");
        //System.out.println("The current balance is "+myAccount.getBalance());
        webWriter.println("</html>");
        webWriter.println("</body>");



    }

}
