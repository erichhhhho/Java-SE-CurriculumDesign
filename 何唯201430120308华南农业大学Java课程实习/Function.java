package 课设1;
public class Function
{
   private int a, b, c,d,e,f,g;
   public Function()
   {
      a = b = c = d=e=f=g=0;
   }

   public Function (int aValue, int bValue, int cValue,int dValue, int eValue, int fValue,int gValue)
   {
      a = aValue;
      b = bValue;
      c = cValue;
      d = dValue;
      e = eValue;
      f = fValue;
      g = gValue;
      
   }
		//计算各点函数值
   public double computeValue(double x)
   {
      return a*x*x*x*x*x*x + b*x*x*x*x*x + c*x*x*x*x+d*x*x*x+e*x*x+f*x+g;
   }
		//判断函数是否恒为0
   public boolean isZero(){
	   return (a==0 && b==0 && c==0&&d==0&& e==0 && f==0&&g==0);
   }
  	 //规范函数表达式
   public String toString()
   {
      StringBuffer function = new StringBuffer();//比String更适合频繁修改
		//若各系数全为0，则显示0
      if (a==0 && b==0 && c==0&&d==0&& e==0 && f==0&&g==0)
    	  function.append("0");
      else
      {
         if (a != 0)
         {
            if (a==-1)
            	function.append("-");//a=-1就只显示-号而不是-1
            else if(a==1)
            {}
            else
            	function.append(a);
            function.append( "x^6" );//最后加上x^6
         }
         if (b != 0)
         {
             if(b>0)
             { 
            	 function.append("+");//b大于0就加上加号
               if(b!=1)
            	   function.append(b);
               }
             else if(b<0)
            { if(b==-1)
            	function.append("-");//b=-1只显示-号而不是-1
              else
            	  function.append(b);//b<0就自动包含-号，因此直接加上b就好
            } 
             function.append("x^5");
         }
         if (c != 0)
         {
             if(c>0)
             { 
            	 function.append("+");
               if(c!=1)
            	   function.append(c);
               }
             else if(c<0)
            { if(c==-1)
            	function.append("-");
              else
            	  function.append(c);
            } 
             function.append("x^4");
         }
         if (d != 0)
         {
             if(d>0)
             { 
            	 function.append("+");
               if(d!=1)
            	   function.append(d);
               }
             else if(d<0)
            { if(d==-1)
            	function.append("-");
              else
            	  function.append(d);
            } 
             function.append("x^3");
         }
         if (e != 0)
         {
             if(e>0)
             { 
            	 function.append("+");
               if(e!=1)
            	   function.append(e);
               }
             else if(e<0)
            { if(e==-1)
            	function.append("-");
              else
            	  function.append(e);
            } 
             function.append("x^2");
         }
         if (f != 0)
         {
             if(f>0)
             { 
            	 function.append("+");
               if(f!=1)
            	   function.append(f);
               }
             else if(f<0)
            { if(f==-1)
            	function.append("-");
              else
            	  function.append(f);
            } 
             function.append("x");
         }
         if (g != 0)
         {
            if (g > 0)       
            	function.append("+");
            function.append(g);
         }
      }
      
         char c = function.charAt(0);//如果出现第一个字符是+号，就删去
         if (c=='+')
        	 function.deleteCharAt(0);    
        	 function.append("的图像");
      return function.toString();
   }
}