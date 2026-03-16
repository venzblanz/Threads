package practice;

public class SingleSphenic {
    public static boolean isSphenic(int n){
        int count = 0;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                count++;
                n/=i;
                if(n%i == 0) return false;
            }
        }
        if(n > 1)count++;
        return count == 3;
    }
    static void main(String[] args) {
        int lim = 1000;
        for(int i = 1; i <= lim; i++){
            if(isSphenic(i)){
                System.out.println(i);
            }
        }
//        for(int n = 1; n <= lim; n++){
//            int temp = n;
//            int count = 0;
//            int lastPrime = -1;
//            boolean valid = true;
//
//            for(int i = 2; i <= temp; i++){
//                if(temp % i == 0){
//                    boolean prime = true;
//                    for(int j = 2; j * j <= i; j++){
//                        if(i%j == 0){
//                            prime = false;
//                            break;
//                        }
//                    }
//                    if(!prime){
//                        valid = false;
//                        break;
//                    }
//                    if(i == lastPrime){
//                        valid = false;
//                        break;
//                    }
//                    lastPrime = i;
//                    count++;
//
//                    temp /= i;
//                    i--;
//
//                    if(count > 3){
//                        valid = false;
//                        break;
//                    }
//                }
//            }
//
//            if(valid && count  == 3  && temp == 1){
//                System.out.println(n);
//            }
//        }
    }
}
