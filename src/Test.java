import java.io.*;
import java.util.ArrayList;
import java.util.function.IntBinaryOperator;

/**
 * Created by Valentin on 06.12.2016.
 */
public class Test {
    public static void maxLengthOfSeq(){
        File file = new File ("input.txt");
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream( file ), "UTF-8"
                    )
            );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String seq = null;
        try {
            seq = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(seq);
        boolean isOneSeq = false;
        int maxLength = 0;
        int tmpLength = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (!isOneSeq && seq.charAt(i)=='1'){
                isOneSeq = true;
                tmpLength++;
            }
            else{
                if (isOneSeq)
                if ( seq.charAt(i)=='1')
                    tmpLength++;
                else{
                    isOneSeq = false;
                    if (tmpLength>maxLength)
                        maxLength = tmpLength;
                        tmpLength = 0;
                }
            }
        }
        System.out.println(maxLength);
        File outputFile = new File("output.txt");
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(outputFile.getAbsoluteFile());

            try {
                out.print(maxLength);
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static ArrayList<Integer> findAllDividers(int number){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 1; 2*i <= number; i++) {
            if (number%i==0){
                result.add(i);
                System.out.println(i);
            }
        }
        result.add(number);
        System.out.println(number);
        return  result;
    }
}
