class PalindromicNumber {
    int num;
    public PalindromicNumber(int num) {
        this.num = num;
    }

    public boolean isValid() {
        return this.isPalindrome() && this.isSum();
    }

    public boolean isPalindrome() {
        int reverse = 0;
        int tmp = num;
        while(tmp != 0) {
            reverse = reverse * 10;
            reverse += tmp % 10;
            tmp = tmp / 10;
        }
        return reverse == num;
    }

    public boolean isSum() {
        int count = 0;

        for(int i = 2; i*i*i < num; i++) { // cubes
            for(int j = 2; j*j < num; j++) { // squares
                int sum = i*i*i + j*j;
                if(sum == num) {
                    count++;
                }
                else if (sum > num) {
                    break;
                }
            }
            if(count > 4) {
                break;
            }
        }

        return count == 4;
    }

    public int getNum() {
        return num;
    }
}

public class ThreeHundredFortyEight {
    public static void main(String[] args) {
        int count = 0;
        int[] nums = {0, 0, 0, 0, 0};

        int i = 1;
        while(count < 5) {
            PalindromicNumber num = new PalindromicNumber(i);
            if(num.isValid()) {
                nums[count] = num.getNum();
                count++;
            }
            i++;
        }

        System.out.println(nums[0] + nums[1] + nums[2] + nums[3] + nums[4]);
    }
}
