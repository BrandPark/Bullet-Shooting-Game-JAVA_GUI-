package client.game2;

public interface Model<T> {
	public void add(T model);
	public T poll();
}
