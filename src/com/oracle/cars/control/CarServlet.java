package com.oracle.cars.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.cars.model.Car;
import com.oracle.cars.model.CarDAO;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private CarDAO  dao=new CarDAO();
	/**
	 * Servlet复用
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//只要调用CarServlet 都会进入这个方法， 然后再根据用户传过来的method参数做分流
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String method=request.getParameter("method");
		switch (method) {
			case "listAll":
			{
				System.out.println("查看所有的");
				//查询数据库获得所有二手车辆信息然后返回到页面上显示
				List<Car> cars=dao.listAllCars();
				System.out.println(cars.get(0).getPinpaiming());
				System.out.println(cars.size());
				
				//讲查询的数据存储到request范围内
				request.setAttribute("cars", cars);
				
				//数据存储完毕，跳转到页面上准备在页面上显示所有二手车信息
				request.getRequestDispatcher("carList.jsp").forward(request, response);
				
				
				break;
			}
			case "add":
			{
				System.out.println("添加");
				break;
			}
			case "update":
			{
				System.out.println("修改");
				break;
			}
			case "delete":
			{
				System.out.println("删除");
				//1.获取用户超链接传过来的汽车编号
				String carid=request.getParameter("carid");
				//2.调用dao方法将这个编号的车辆删除掉
				boolean result=dao.deleteCar(Integer.parseInt(carid));
				//3.将删除的结果存储到request范围内，然后再jsp上判断结果提示用户操作结果
				request.setAttribute("deleteResult", result);
				//4.跳转到列表页面
				request.getRequestDispatcher("CarServlet?method=listAll").forward(request, response);
				break;
			}
	
		}
	}
}
