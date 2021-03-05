package app;

public class KKProtocol {
    private int state = 0; // 0 (KK state), 1 (State), 2 (Terrible Joke and Go again?)
    private String[] variationWhosThere = 
    {"whos there", "Who's There", "Whos There", "whos There", "Whos there", "Who's there"};
    private String[] variationYour = 
    {"Your who?", "Your who", "Your Who?", "Your Who", "your who", "your who?"};


    public String processInput(String inp) {
        String response = "";

        if (state == 0) {
            response = "Knock Knock";
            state++;
        } else if (state == 1) {
            if (arrayContains(this.variationWhosThere, inp)) {
                response = "Your";
                state++;
            } else {
                response = "You're supposed to say \"Who's There!\"";
            }
        } else {
            if (arrayContains(this.variationYour, inp)) {
                response = "Your programming skills are wack...";
            } else {
                response = "You're supposed to say \"Your who?\"";
            }
        }

        return response;
    }

    public static <T> boolean arrayContains (final T[] arr, final T str ) {
        for(final T ele: arr) {
            if (ele == str || ele.equals(str))
                return true;
        }
        return false;
    }
}
