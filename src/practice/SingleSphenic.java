package practice;

public class SingleSphenic {
    static void main(String[] args) {
        int lim = 1000;
        for(int n = 1; n <= lim; n++){
            int temp = n;
            int count = 0;
            int lastPrime = -1;
            boolean valid = true;

            for(int i = 2; i <= temp; i++){
                if(temp % i == 0){
                    boolean prime = true;
                    for(int j = 2; j * j <= i; j++){
                        if(i%j == 0){
                            prime = false;
                            break;
                        }
                    }
                    if(!prime){
                        valid = false;
                        break;
                    }
                    if(i == lastPrime){
                        valid = false;
                        break;
                    }
                    lastPrime = i;
                    count++;

                    temp /= i;
                    i--;

                    if(count > 3){
                        valid = false;
                        break;
                    }
                }
            }

            if(valid && count  == 3  && temp == 1){
                System.out.println(n);
            }
        }
    }
}
