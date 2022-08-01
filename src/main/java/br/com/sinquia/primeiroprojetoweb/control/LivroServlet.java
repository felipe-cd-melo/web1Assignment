package br.com.sinquia.primeiroprojetoweb.control;

import br.com.sinquia.primeiroprojetoweb.bo.LivroBOI;
import br.com.sinquia.primeiroprojetoweb.model.Livro;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = "/api/*")
public class LivroServlet extends HttpServlet {

    private LivroBOI livroBOI;

    @Inject
    public LivroServlet(LivroBOI livroBOI){
        this.livroBOI = livroBOI;
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path){
            case "/create-livro":
                doPost(request,response);
                break;
            case "/list-livros":
                doGet(request, response);
                break;
            case "/update-jsp":
                callPutJsp(request,response);
                break;
            case "/update-livro":
                doPut(request, response);
                break;
            case "/delete-livro":
                doDelete(request, response);
                break;
            default:
                super.service(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Livro livro = createLivro(req);
        livroBOI.save(livro);

        req.setAttribute("idLivroCreated",livro.getId());
        List<Livro> livros = livroBOI.findAll();
        req.setAttribute("listaLivros", livros);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-livros.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Livro> livros = livroBOI.findAll();
        req.setAttribute("listaLivros", livros);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-livros.jsp");
        dispatcher.forward(req,resp);
    }

    private void callPutJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Livro livro = livroBOI.getById(id);
        req.setAttribute("livro", livro);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/update-livro.jsp");
        dispatcher.forward(req,resp);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Livro livroNew = createLivro(req);
        livroNew.setId(Long.valueOf(id));
        livroBOI.update(livroNew);

        req.setAttribute("idLivroUpdated",id);
        List<Livro> livros = livroBOI.findAll();
        req.setAttribute("listaLivros", livros);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-livros.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        livroBOI.delete(id);

        List<Livro> livros = livroBOI.findAll();
        req.setAttribute("listaLivros", livros);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/list-livros.jsp");
        dispatcher.forward(req,resp);
    }

    private Livro createLivro(HttpServletRequest req){
        String nome = req.getParameter("nome");
        String autor = req.getParameter("autor");
        Livro livro = new Livro(nome, autor);
        return livro;
    }

}

