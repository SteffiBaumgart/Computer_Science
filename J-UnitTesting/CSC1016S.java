/**
 * Created by Baumgart on 2015/09/16.
 */
public class CSC1016S implements Student{

    private String name;
    private float finalMark;
    private float Prac;
    private float Test;
    private float PracTest;
    private float Exam;


    public void setName (String name){

        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setMark ( String category, int mark ){
        if (category.equals("pracs")){

            Prac = mark;
        }
        else if(category.equals("practests")){

            PracTest = mark;
        }
        else if(category.equals("tests")){

            Test =  mark;
        }
        else{
            Exam = mark;
        }

    }


    public float getFinal (){
        finalMark = (float)((0.15 * Prac) + (0.15 * Test) + (0.10 * PracTest) + (0.60 * Exam) );
        return finalMark;
    }
}




