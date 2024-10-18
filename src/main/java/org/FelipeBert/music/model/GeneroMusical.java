package org.FelipeBert.music.model;

public enum GeneroMusical {
    ROCK("rock"),
    SERTANEJO("sertanejo"),
    POP("pop");

    private String genero;

    GeneroMusical(String genero) {
        this.genero = genero;
    }

    public static GeneroMusical fromString(String text){
        for(GeneroMusical generoMusical : GeneroMusical.values()){
            if(generoMusical.genero.equalsIgnoreCase(text)){
                return generoMusical;
            }
        }
        throw new IllegalArgumentException("Genero Musical não Encontrado!");
    }
}
