package stringcalculator;

class CalculationResult {
    private int sum;
    private int num;

    public int getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }

    private void setSum(int sum) {
        this.sum = sum;
    }

    private void setNum(int num) {
        this.num = num;
    }

    // 모든 숫자의 총합을 위한 메서드
    public void addToSum() {
        setSum(getSum() + getNum());
        setNum(0);
    }

    // 특정 숫자를 구하기 위한 메서드
    public void addToNum(int digit) {
        setNum(getNum() * 10 + digit);
    }
}
