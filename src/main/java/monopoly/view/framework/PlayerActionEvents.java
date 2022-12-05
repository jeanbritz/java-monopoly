package monopoly.view.framework;

/**
 * Interface class which defines the callback methods. In this way the callback
 * methods acts as an API and gives the user the ability to defined the callback
 * methods in the class this view is declared in.
 * 
 * @author Jean Britz
 *
 */
public interface PlayerActionEvents {

	public void onRollClick();

	public void onEndTurnClick();

	public void onBuyClick();

	public void onCheckRentClick();

}
