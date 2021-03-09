package DS_StackAndQueue_Q3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DS_StackAndQueue_Q2.Queue;
import DS_StackAndQueue_Q2.QueueClass;

public class Main {
	public static void main(String args[]) throws IOException {

		List<Courses> courses = new ArrayList<Courses>();
		QueueClass<Student> student_queue;

		Courses course;
		String course_name = "";

		Student student;
		List<String> student_data;
		int seat = 0;

		// Here we are reading course details from excel file and storing in the
		// list.
		FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\ranvijay.singh_metac\\Downloads\\Courses.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (Row row : sheet) {

			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case NUMERIC:
					seat = (int) cell.getNumericCellValue();
					break;
				case STRING:
					course_name = cell.getStringCellValue();
					break;
				default:
					break;
				}
			}

			course = new Courses(course_name, seat);
			courses.add(course);
		}

		// Here we are reading student details from excel file and creating
		// queue.
		fis = new FileInputStream(new File(
				"C:\\Users\\ranvijay.singh_metac\\Downloads\\StudentList.xlsx"));
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);

		System.out.println();

		student_queue = new QueueClass<Student>(sheet.getLastRowNum() + 1);

		for (Row row : sheet) {
			student_data = new ArrayList<String>();

			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case STRING:
					student_data.add(cell.getStringCellValue());
					break;
				default:
					break;
				}
			}

			student = new Student(student_data);
			student_queue.Enqueue(student);

		}
		workbook.close();

		/*
		 * We are writing data in the Excel file
		 */
		workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet("Student Allocation ");

		// Create row object
		XSSFRow row;

		int rowid = 0;
		Student student_object;

		// Loop for scanning queue
		while ((student_object = student_queue.Dequeue()) != null) {
			row = spreadsheet.createRow(rowid++);
			int cellid = 0;
			boolean flag = false;
			Cell cell = row.createCell(cellid++);
			cell.setCellValue(student_object.getName());
			List<String> course_prefered_list = student_object
					.getPreferedList();

			// Loop for scanning each preferred courses of a student until he is
			// allocated to any course
			for (String courseName : course_prefered_list) {
				// Loop for checking seat availability for courses
				for (Courses course_data : courses) {
					if (courseName.equals(course_data.getCourseName())) {
						if (course_data.getSeat() > 0) {
							cell = row.createCell(cellid++);
							cell.setCellValue(courseName);
							course_data.decreaseSeat();
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					break;
				}
			}

		}

		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(
				new File(
						"C:\\Users\\ranvijay.singh_metac\\Downloads\\Student_Allocation.xlsx"));

		workbook.write(out);
		out.close();

		System.out.println("Seats left in the courses :");
		for (Courses c : courses) {
			c.display();
		}

		workbook.close();
	}
}
