import java.util.Scanner;

public class AdapterPatternExample {

    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    public static class Paytm {
        public void makePayment(double amount) {
            System.out.println("Processing payment of Rs." + amount + " through Paytm.");
        }
    }

    public static class PhonePe {
        public void pay(double amount) {
            System.out.println("Paying Rs." + amount + " through PhonePe.");
        }
    }

    public static class GooglePay {
        public void transfer(double amount) {
            System.out.println("Transferring Rs." + amount + " through Google Pay.");
        }
    }

    public static class PaytmAdapter implements PaymentProcessor {
        private Paytm paytm;

        public PaytmAdapter(Paytm paytm) {
            this.paytm = paytm;
        }

        @Override
        public void processPayment(double amount) {
            paytm.makePayment(amount);
        }
    }

    public static class PhonePeAdapter implements PaymentProcessor {
        private PhonePe phonePe;

        public PhonePeAdapter(PhonePe phonePe) {
            this.phonePe = phonePe;
        }

        @Override
        public void processPayment(double amount) {
            phonePe.pay(amount);
        }
    }

    public static class GooglePayAdapter implements PaymentProcessor {
        private GooglePay googlePay;

        public GooglePayAdapter(GooglePay googlePay) {
            this.googlePay = googlePay;
        }

        @Override
        public void processPayment(double amount) {
            googlePay.transfer(amount);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Paytm paytm = new Paytm();
        PhonePe phonePe = new PhonePe();
        GooglePay googlePay = new GooglePay();

        PaymentProcessor paytmProcessor = new PaytmAdapter(paytm);
        PaymentProcessor phonePeProcessor = new PhonePeAdapter(phonePe);
        PaymentProcessor googlePayProcessor = new GooglePayAdapter(googlePay);

        System.out.println("Select Payment Gateway:");
        System.out.println("1. Paytm");
        System.out.println("2. PhonePe");
        System.out.println("3. Google Pay");
        System.out.print("Enter the number of the payment gateway: ");
        int choice = scanner.nextInt();

        System.out.print("Enter the amount to process (in Rs.): ");
        double amount = scanner.nextDouble();

        switch (choice) {
            case 1:
                paytmProcessor.processPayment(amount);
                break;
            case 2:
                phonePeProcessor.processPayment(amount);
                break;
            case 3:
                googlePayProcessor.processPayment(amount);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        scanner.close();
    }
}
