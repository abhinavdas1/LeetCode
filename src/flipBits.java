/**
 * Created by abhinavdas on 1/12/17.
 */
/*
public class flipBits {
    public void flip()
    {
        int arr[] = {1, 1, 1, 1, 1, 1, 1, 1};
        int sum=0,maxsum=0,num=0,count=0;
        int startIndex=0,stopIndex=0,prevIndex=0;


        for(int i=0;i<arr.length;i++){
            if(arr[i] == 1){
                num = -1;
                count++;
            }else if(arr[i] == 0){
                num = 1;
            }
            sum = sum + num;
            if(maxsum<sum){
                maxsum = sum;
                prevIndex = startIndex;
                stopIndex = i;
            }else if(sum<0){
                sum = 0;
                startIndex = i+1;
            }

        }
        for(int j=prevIndex;j<=stopIndex;j++){
            if(arr[j]==0)
                arr[j]=1;
            else
                arr[j]=0;
        }
        num=0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]==1)
            {
                num++;
            }
        }
        System.out.println(num);
    }
}
*/