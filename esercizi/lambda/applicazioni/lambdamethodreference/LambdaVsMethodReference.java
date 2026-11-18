package applicazioni.lambdamethodreference;

@FunctionalInterface
interface MethodReference {
    void helloMethodReference();
}

public class LambdaVsMethodReference {

    static void helloMethodReference() {
        System.out.println("From helloMethodReference!");
    }

    public static void main(String[] args) {
        MethodReference methodReference = LambdaVsMethodReference::helloMethodReference;
        methodReference.helloMethodReference();
        // MethodReference methodReferenceLambda = () ->
        // LambdaVsMethodReference.helloMethodReference();
        // methodReferenceLambda.helloMethodReference();
    }
}
