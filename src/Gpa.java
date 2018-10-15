import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Gpa {

        private ArrayList<HashMap<String, String>> classList = new ArrayList<>();

        public void addClass()
        {
            Scanner in = new Scanner(System.in);
            String course;
            String credit;
            String letterGrade;
            while(true)
            {
                System.out.println("Please type in a course or 'q' to quit.");
                course = in.nextLine();
                if(course.equals("q"))
                {
                    break;
                }
                else {
                    System.out.println("Enter credit hours: ");
                    credit = in.nextLine();
                    System.out.println("Enter letter grade: ");
                    letterGrade = in.nextLine();
                    HashMap<String, String> movieMap = new HashMap<>();
                    movieMap.put("course", course);
                    movieMap.put("credit", credit);
                    movieMap.put("grade", letterGrade);
                    classList.add(movieMap);
                }
            }
            in.close();
        }

        public void displayClasses()
        {
            System.out.printf("%-10s %-14s %s\n", "Course", "Credit Hours", "Grade");
            for(HashMap<String, String> map : classList)
            {
                System.out.printf("%-10s %-14s %s\n",map.get("course"), map.get("credit"), map.get("grade"));
            }

        }

        public void calculateGpa()
        {
            double totalGrade = 0;
            int totalCredit = 0;
            for(HashMap<String, String> map: classList)
            {
                if(map.get("grade").equals("A"))
                {
                    totalGrade += 4 * Integer.parseInt(map.get("credit"));
                }
                else if(map.get("grade").equals("B"))
                {
                    totalGrade += 3* Integer.parseInt(map.get("credit"));
                }
                else if(map.get("grade").equals("C"))
                {
                    totalGrade += 2* Integer.parseInt(map.get("credit"));
                }
                else if(map.get("grade").equals("D"))
                {
                    totalGrade += Integer.parseInt(map.get("credit"));
                }
                else
                {
                  totalGrade += 0;
                }
                totalCredit += Integer.parseInt(map.get("credit"));
            }
            double gpa = totalGrade / totalCredit;
            DecimalFormat df = new DecimalFormat("###.##");
            gpa = Double.parseDouble(df.format(gpa));
            System.out.printf("Total Grade Points: %.2f\nTotal Credits: %d\nGPA: %.2f",totalGrade,totalCredit,gpa);
        }
    }
