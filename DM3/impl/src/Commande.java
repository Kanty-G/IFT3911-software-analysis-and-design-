public abstract class Commande
{

    Administrateur invoker;
    Administrateur receiver;

    public void execute()
    {
        // TODO - implement Commande.execute
        throw new UnsupportedOperationException();
    }

    public void unexecute()
    {
        // TODO - implement Commande.unexecute
        throw new UnsupportedOperationException();
    }

}