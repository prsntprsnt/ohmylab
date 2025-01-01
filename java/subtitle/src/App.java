import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class App {
    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\prsntl22\\Desktop\\루리의섬\\작업중\\RURINOSHIMA_1\\";
        BufferedReader br = new BufferedReader(new FileReader(path + "A1_t00.smi"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(path + "temp.smi"));

        int lineNo = 1;
        String catchYn = "N";
        String str;

        while ((str = br.readLine()) != null)
        {
            if (lineNo != 1)
            {
                bw.newLine();
            }

            if (str.indexOf("당신 저 아이와 진심으로<br>마주 대해 볼 각오 있으신가요?") > 0)
            {
                catchYn = "Y";
            }

            if (catchYn == "Y")
            {
                if(str.indexOf("SYNC Start=") > 0)
                {
                    String time = str.substring(str.indexOf("=") + 1, str.indexOf(">"));
                    int editTime  = Integer.parseInt(time) + 999999;
                    time = editTime + "";

                    bw.write(str.replace(str.substring(str.indexOf("=") + 1, str.indexOf(">")), time));
                }
                else
                {
                    bw.write(str);
                }
            }
            else
            {
                bw.write(str);
            }

            lineNo++;
        };

        bw.flush();
        bw.close();
        br.close();

        File file = new File(path + "A1_t00.smi");
        file.delete();

        file = new File(path + "temp.smi");
        file.renameTo(new File(path + "A1_t00.smi"));
        
        if (catchYn == "N")
        {
            System.out.println("수정 된 부분 없음");
        }
        else
        {
            System.out.println("수정 완료");
        }
    }
}
