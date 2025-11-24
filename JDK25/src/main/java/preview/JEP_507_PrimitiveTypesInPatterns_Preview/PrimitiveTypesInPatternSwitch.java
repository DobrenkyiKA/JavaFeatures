void main() {
    switch (X.getStatus()) {
        case 0 -> System.out.println("okay");
        case 1 -> System.out.println("warning");
        case 2 -> System.out.println("error");
        case int in -> System.out.println("unknown status: " + in);
    }
}

static class X {
    static int getStatus() {
        return 0;
    }
}

