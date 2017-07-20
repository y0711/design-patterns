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
	public Actor getActor() {
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

class ActorController {
	public Actor construct(ActorBuilder ab) {
		// Assume ab is not null.
		ab.setFace();
		ab.setHair();
		return ab.getActor();
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
public class Builder {
	public static void main(String[] args) {
		ActorController ac = new ActorController();
		ActorBuilder ab = (ActorBuilder)XMLUtil.getBean("config.xml");
		Actor actor = ac.construct(ab);
		out.println("Actor face is " + actor.face + ", hair is " + actor.hair);
	}
}
