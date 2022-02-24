package br.com.festa;

public interface Recepcionista {
    public boolean isAgeValid(Convite convite) throws RuntimeException;
    public boolean isPartyOpen(Convite convite) throws RuntimeException;
    public boolean isPartyValid(Convite convite) throws RuntimeException;
    public boolean isPartyDateValid(Convite convite) throws RuntimeException;
    public boolean isPartyFull(Convite convite) throws RuntimeException;

}
