package br.com.yanaga.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmbeddedServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Board board;

	@Override
	public void init() throws ServletException {
		board = Board.fromString(System.getProperty("os.arch"));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		URLConnection conn = new URL(board.getLigar()).openConnection();
		conn.connect();
		conn.getInputStream();
		try {
			Thread.sleep(500);
		}
		catch (InterruptedException e) {
		}
		conn = new URL(board.getDesligar()).openConnection();
		conn.connect();
		conn.getInputStream();
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body><h1>Hello from the clouds</h1></body></html>");
	}

}