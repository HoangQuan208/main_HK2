package BT7_10;
import java.util.Scanner;
class Date
{
    private int day;
    private int month;
    private int year;

    public Date() {
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws IllegalArgumentException{
        this.day=day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws IllegalArgumentException{
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws IllegalArgumentException{
        this.year = year;
    }
    public void display()
    {
        System.out.println("Day : "+getDay());
        System.out.println("Month : "+ getMonth());
        System.out.println("Year : "+getYear());
    }
}
class EnhancedDate extends Date
{

    public EnhancedDate() {
        super();
    }
    
    public EnhancedDate(int day, int month, int year) {
        super(day, month, year);
    }
    
    public boolean isLeapYear()
    {
        return (((getYear() % 4 == 0) && (getYear() % 100 != 0)) ||  (getYear() % 400 == 0)); 
    }
    
    public int tinhSoNgayTrongThang(int month, int year)
    {
    int day = 0;

            switch (getMonth())
            {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: 
                    day=31;
                    break;
            case 4:
            case 6:
            case 9:
            case 11: 
                    day=30;
                    break;
            case 2:
                    if (isLeapYear())
                    {
                      day=29;
                    }
                    else
                    {
                        day=28;
                    }
                    break;
            }

            return day;
    }
    
    public boolean isValidDate()
    {
        if(getYear() >9999 || getYear()<1) return false;
        if(getMonth() >12 || getMonth() <1) return false;
        if(getDay()<=0 || getDay()>tinhSoNgayTrongThang(getMonth(), getYear())) return false;
        return true;

    }
    public void nextDay()
    {
        int day=getDay()+1;
        setDay(day);
        if(day> tinhSoNgayTrongThang(getMonth(),getYear()))
        {
            day=1;
            setDay(day);
            int month=getMonth()+1;
            setMonth(month);
            if(month==13)
            {
              month=1;
                setMonth(month);
                int year=getYear()+1;
                setYear(year);
           }
        }
        System.out.println("-----------------");
        System.out.println("    Next Day");
        display();
    }
    public void prevDay()
    {
        setDay(getDay()-1);
        if(getDay()<1)
        {
            
            setMonth(getMonth()-1);
            if(getMonth()==0)
            {
                setMonth(12);
                setYear(getYear()-1);
            }
            setDay(tinhSoNgayTrongThang(getMonth(), getYear()));
        }
        System.out.println("-----------------");
        System.out.println("    Prev Day");
        display();
    }
    public int compareTo(Date d1)
    {
        Date d2=new Date();
        switch((d1.getYear())-(d2.getYear()))
        {
            case 1:
                    return 1;
            case 0: 
                    switch(d1.getMonth()-d2.getMonth())
                    {
                        case 1: 
                            return 1;
                        case 0: 
                            switch(d1.getDay()-d2.getDay())
                            {
                                case 1: 
                                    return 1;
                                case 0: 
                                    return 0;
                                case -1:
                                    return -1;
                            }
                        case -1:
                            return -1;
                    }
            case -1: 
                    return -1;
        }
        return 0;
    }
//    public void check(Date d) throws Exception
//    {
//        if(!isValidDate().d) throw IllegalArgumentException("Ngày không hợp lệ!!");
//        
//    }
    public void doi( Date d2)
    {
        Date d1=new Date();
        try
        {
            Date temp=null;
            if(compareTo(d2)==1)
            {
                temp=d1;
                d1=d2;
                d2=temp;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Lỗi !!");
        }
        
    }


}

public class test {
    static void menu()
    {
        System.out.println("0. Thoát");
        System.out.println("1. Xuất những ngày thuộc năm nhuận");
        System.out.println("2. Xuất ngày liền trước và liền sau của mỗi ngày");
        System.out.println("3. Tìm min max trong các ngày");
        System.out.println("4. Xóa ngày trùng ");
        System.out.println("5. Sắp xếp các ngày ");
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

                EnhancedDate date[]=new EnhancedDate[5];
                date[1]=new EnhancedDate(28, 2, 2021);
                date[2]=new EnhancedDate(31, 1, 2020);
                date[3]=new EnhancedDate(8, 2, 2000);
                date[4]=new EnhancedDate(31, 12, 2021);
                date[0]=new EnhancedDate(10, 1, 2021);
                int n;
                do
                {
                    menu() ;
                    System.out.println("Nhập lựa chọn : ");
                    n=sc.nextInt();
                    switch(n)
                    {
                        case 0: 
                            System.out.println("bye!!");
                            break;
                        case 1:
                            for(int i =0; i<date.length ; i++)
                            {
                                if(date[i].isLeapYear())
                                {
                                   System.out.println("Những ngày thuộc năm nhuận: " );
                                    System.out.println("-----------------------------");
                                   date[i].display();
                                    System.out.println("-----------------------------");
                                }
                            }
                            break;
                        case 2:
                            for(int i =0; i<date.length ; i++)
                            {
                                System.out.println("Ngày Liền trước và liền sau của mỗi ngày là : ");
                                System.out.println("***************************");
                                date[i].nextDay();
                                date[i].prevDay();
                            }
                            break;

                    }
                }while(n!=5);
                //  if(!date.isLeapYear()) System.out.println("Không phải năm nhuận");
                //else System.out.println("Năm nhuận");
                // date.nextDay();
                //date.prevDay();
        
    }
}
