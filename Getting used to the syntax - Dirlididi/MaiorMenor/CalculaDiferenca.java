public class CalculaDiferenca {
    public int[] nums;
    public int maior;
    public int menor;

    public CalculaDiferenca(int num1, int num2, int num3, int num4, int num5) {
        this.nums = new int[5];
        this.nums[0] = num1;
        this.nums[1] = num2;
        this.nums[2] = num3;
        this.nums[3] = num4;
        this.nums[4] = num5;
        achaMaior();
        achaMenor();
    }

    public void achaMaior() {
        this.maior = this.nums[0];
        for(int a = 0; a < this.nums.length; a++) {
            if(this.nums[a] > this.maior) {
                this.maior = this.nums[a];
            }
        }
    }
    public void achaMenor() {
        this.menor = this.nums[0];
        for(int b = 0; b < this.nums.length; b++) {
            if(this.nums[b] < this.menor) {
                this.menor = this.nums[b];
            }
        }
    }
    public int Diferenca() {
        return this.maior - this.menor;
    }
    
}