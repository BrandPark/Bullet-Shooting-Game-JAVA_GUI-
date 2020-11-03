package client.game2;

public interface Dispatcher<T> {
	public void startThread();
	public Model<T> getModel();
}
