import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double height;
        double weight;
        double bmiScore;
        String category;
        String recommendation;

        System.out.println("Welcome to the BMI(Body Mass Index) calculator program");
        System.out.println("input your height in inches:");
        height = scanner.nextDouble();
        System.out.println("input your weight in pounds:");
        weight = scanner.nextDouble();

        bmiScore = calculateBMI(height, weight);
        category = bmiCategory(bmiScore);
        recommendation = bmiRecommendation(category);

        System.out.println("your BMI score is " + bmiScore + " that means you are categorized" +
                " as " + category + ". our best recommendation for you is to " + recommendation);
    }

    public static double calculateBMI (double height, double weight) {
        double bmiScore;
        bmiScore = 703 * (weight / (height * height));
        bmiScore = Math.round(bmiScore * 10.0) / 10.0;
        return bmiScore;
    }

    public static String bmiCategory (double bmiScore) {
        if (bmiScore < 16) {
            return "severely underweight";
        }
        else if (bmiScore < 18.5) {
            return "underweight";
        }
        else if (bmiScore < 25) {
            return "normal";
        }
        else if (bmiScore < 30) {
            return "overweight";
        }
        else if (bmiScore < 35) {
            return "moderately obese";
        }
        else if (bmiScore < 40) {
            return "severely obese";
        }
        else {
            return "morbidly obese";
        }
    }

    public static String bmiRecommendation (String category){
        return switch (category) {
            case "severely underweight" -> "gain weight";
            case "underweight" -> "gain a little weight";
            case "normal" -> "stay the same";
            case "overweight" -> "lose weight";
            case "moderately obese" -> "lose a lot of weight";
            case "severely obese" -> "lose a bunch of weight";
            case "morbidly obese" -> "lose crazy weight";
            default -> "no recommendation";
        };
    }
}