package com.example.learninghtmlandcssapp;

import java.util.ArrayList;

public class courseClass {
    // properties
    private static courseClass courseclass;
    private static ArrayList<Courses> CourseList = new ArrayList<Courses>();

    // private constructor
    private courseClass() {
        // add the initial data to the list
        CourseList.add(new Courses(1, "Introduction to the Javascript", " 5 Minutes 10 Seconds", false, "After reading the last couple of articles you should now know what JavaScript is, what it can do for you, how you use it alongside other web technologies, and what its main features look like from a high level. In this article, we will get down to the real basics, looking at how to work with the most basic building blocks of JavaScript — Variables.", "", "https://www.youtube.com/watch?v=1HakS7KsbCk"));
        CourseList.add(new Courses(2, "What is Javascript?", "5 Minutes 11 Seconds", false, "JavaScript is a scripting or programming language that allows you to implement complex features on web pages — every time a web page does more than just sit there and display static information for you to look at — displaying timely content updates, interactive maps, animated 2D/3D graphics, scrolling video jukeboxes, etc. — you can bet that JavaScript is probably involved", "", "https://www.youtube.com/watch?v=upDLs1sn7g4"));
        CourseList.add(new Courses(3, "Variable and Conditionals", "17 Minutes 16 Seconds", false, "The conditional (ternary) operator is the only JavaScript operator that takes three operands: a condition followed by a question mark ( ? ), then an expression to execute if the condition is truthy followed by a colon ( : ), and finally the expression to execute if the condition is falsy.", "", "https://www.youtube.com/watch?v=vaZpDYOuprA"));
        CourseList.add(new Courses(4, "Loops", "6 Minutes 46 Seconds", false, "Loops offer a quick and easy way to do something repeatedly. This chapter of the JavaScript Guide introduces the different iteration statements available to JavaScript.", "", "https://www.youtube.com/watch?v=s9wW2PpJsmQ"));
    }

    // method of to get the object from the Courses Class
    public static courseClass get() {
        if (courseclass == null)
            courseclass = new courseClass();
        return courseclass;
    }

    // getter
    public ArrayList<Courses> getCourses() {
        return CourseList;
    }

    public void updateStatus(int lessonNumber,boolean value)
    {
        for(Courses course : CourseList)
        {
            if(course.getLessonNumber() == lessonNumber)
            {
              course.setCheckStatus(value);
            }
        }
    }

}