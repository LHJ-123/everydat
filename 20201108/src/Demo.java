import java.util.Scanner;


class JudgeIDNumber
{
    private String iDNumber;

    private boolean IDNumberIsAllRight(String iDNumber)
    {
        boolean result = true;

        for(int i = 0;i<iDNumber.length()-1;i++)
        {
            if((iDNumber.charAt(i)<'0')||(iDNumber.charAt(i)>'9'))
            {
                result=false;
                break;
            }
        }

        return result;
    }

    public void setiDNumber(String iDNumber) throws IDNumberException
    {
        if(iDNumber.length()!=18)
        {
            throw new IDNumberException("身份证号的位数不是18位!");
        }
        else if(!IDNumberIsAllRight(iDNumber))
        {
            throw new IDNumberException("身份证号前17位不能有非数字字符");
        }
        else if((iDNumber.charAt(iDNumber.length()-1)>'9')||(iDNumber.charAt(iDNumber.length()-1)<'0'))
        {
            if((iDNumber.charAt(iDNumber.length()-1)!='X')&&(iDNumber.charAt(iDNumber.length()-1)!='x'))
            {
                throw new IDNumberException("身份证最后一位不为数字字符或X或x");
            }
        }else {this.iDNumber = iDNumber;}
    }

    public String getiDNumber()
    {
        return iDNumber;
    }

    public JudgeIDNumber(String idNumber) throws IDNumberException
    {
        setiDNumber(idNumber);
    }

    public void JudgePersonSexBirth()
    {
        if(Integer.valueOf(iDNumber.charAt(iDNumber.length()-2))%2==0)
        {
            System.out.print("这个人是女性,");
        }
        else
        {
            System.out.print("这个人是男性,");
        }
        System.out.print("出生日期是"+iDNumber.subSequence(6, 10)+"年");
        System.out.print(Integer.valueOf(iDNumber.substring(10, 12))+"月");
        System.out.println(Integer.valueOf(iDNumber.substring(12, 14))+"日");
    }
}
public class Demo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String x = s.next();
        try
        {
            JudgeIDNumber num1=new JudgeIDNumber(x);
            num1.JudgePersonSexBirth();
        }
        catch(IDNumberException IDNE)
        {
            System.out.println(IDNE.getMessage());
        }
    }

}
