package pairmatching.utility;

import pairmatching.enumerate.Course;

public class CourseNameParser {
    public static String[] parse(Course[] courses) {
        String[] courseNames = {"", "", "", "", "", ""};
        for (Course course : courses) {
            courseNames[course.getLevel()] += course.getName() + " | ";
        }
        for (int i=1; i<=5; i++) {
            if (!courseNames[i].equals("")) {
                courseNames[i] = courseNames[i].substring(0, courseNames[i].length()-3);
            }
        }
        return courseNames;
    }
}
