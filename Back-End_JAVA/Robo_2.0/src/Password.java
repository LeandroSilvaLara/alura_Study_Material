import java.util.Random;

 public class Password {
        private int qttgL;
        private int qttyC;

        public Password(int qttgL, int qttyC) {
            this.qttgL = qttgL;
            this.qttyC = qttyC;
        }

        public int getQttgL() {
            return qttgL;
        }

        public int getQttyC() {
            return qttyC;
        }

        public String getNewPassword(int id) {
            Random random = new Random();
            int randomValue = random.nextInt(10000);
            return String.format("senha_%d_%d", id, randomValue);
        }
    }

