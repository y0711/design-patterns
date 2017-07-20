import static java.lang.System.out;

class Actor {
	// Set public to omit get and set methods.
	public String face;
	public String hair;
}

abstract class ActorBuilder {
	protected Actor actor = new Actor();

	public abstract void setFace();
	public abstract void setHair();
	public Actor construct() {
		setFace();
		setHair();
		return actor;
	}
}

class HeroBuilder extends ActorBuilder {
	@Override
	public void setFace() {
		actor.face = "handsome";
	}
	@Override
	public void setHair() {
		actor.hair = "black";
	}
}

class DevilBuilder extends ActorBuilder {
	@Override
	public void setFace() {
		actor.face = "ugly";
	}
	@Override
	public void setHair() {
		actor.hair = "green";
	}
}
public class Builder2 {
	public static void main(String[] args) {
		ActorBuilder ab = (ActorBuilder)XMLUtil.getBean("config2.xml");
		Actor actor = ab.construct();
		out.println("Actor face is " + actor.face + ", hair is " + actor.hair);
	}
}
