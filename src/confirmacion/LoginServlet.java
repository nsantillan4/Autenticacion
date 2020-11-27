package confirmacion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import confirmacion.servicios.Servicios;
import confirmacion.servicios.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Servicios servicio = new Servicios();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		servicio.inicializar();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String clave  = request.getParameter("pwd");
		RequestDispatcher rd ;
		if(servicio.autenticar(clave))
		{
			Usuario usuario = servicio.getDetalle(clave);
			if(usuario != null)
			{
				request.setAttribute("clave", usuario);
				
				
				if(clave.startsWith("0"))
				{
					rd = request.getRequestDispatcher("gestion.jsp");
				}else
				{
					rd = request.getRequestDispatcher("muestra.jsp");
				}
				rd.forward(request, response);
			}else
			{
				rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
				PrintWriter out = response.getWriter();
				out.println("<h1>ERROR</h1>");
			}
		}else
		{
			rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			PrintWriter out = response.getWriter();
			out.println("<h1>ERROR</h1>");
		}
		
	}

}
