package servlet;

import dao.CidadeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cidade;

import java.io.IOException;
import java.io.PrintWriter;

public class CidadeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter saida = resp.getWriter();

        CidadeDAO banco = new CidadeDAO();

        saida.println
                ("<!DOCTYPE html>" +
                        "<html>" +
                            "<head>" +
                                "<title>Consulta Cidades</title>" +
                                "<style>html * {" +
                                "   font-size: 1.25em !important;" +
                                "   font-family: 'Courier New', sans-serif;" +
                                "}" +
                                "</style>" +
                            "</head>" +
                                "<body>" +
                                    "<h2>Cidades do Banco de Dados</h2>" +
                                    "<ul>");

        for (Cidade c : banco.listarCidade()) {
            saida.println
                                        ("<li>"+ c.getNome() + " - " + c.getEstado().getSigla()+ "</li>");
        }

        saida.println(              "</ul>" +
                            "</body>" +
                        "</html>");
    }
}
