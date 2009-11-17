package org.basex.core.proc;

import static org.basex.core.Text.*;

import org.basex.build.fs.FSParser;
import org.basex.build.fs.FSTraversalParser;
import org.basex.core.Prop;
import org.basex.core.User;
import org.basex.core.Commands.Cmd;
import org.basex.core.Commands.CmdCreate;
import org.basex.io.PrintOutput;

/**
 * Evaluates the 'create fs' command and creates a new filesystem mapping from
 * an existing file hierarchy.
 * @author Workgroup DBIS, University of Konstanz 2005-09, ISC License
 * @author Christian Gruen
 * @author Alexander Holupirek
 * @author Bastian Lemke
 */
public final class CreateFS extends ACreate {
  /**
   * Default constructor.
   * @param path filesystem path
   * @param name name of database
   */
  public CreateFS(final String path, final String name) {
    super(User.CREATE, path, name);
  }

  @Override
  protected boolean exec(final PrintOutput out) {
    prop.set(Prop.CHOP, true);
    prop.set(Prop.ENTITY, true);
    if(!prop.is(Prop.FSTRAVERSAL)) return build(new FSParser(args[0], prop),
        args[1]); // old FSParser

    // XQUP-based implementation
    new Close().execute(context);
    final FSTraversalParser p = new FSTraversalParser();
    progress(p);
    p.parse(args[0], context, args[1]);
    final Optimize opt = new Optimize();
    progress(opt);
    opt.execute(context);
    new Open(args[1]).execute(context);
    return info(DBCREATED, args[1], perf);
  }

  @Override
  public String toString() {
    return Cmd.CREATE + " " + CmdCreate.FS + args();
  }
}
