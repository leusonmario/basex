package org.basex.examples.xmldb.eXist;

/**
 * XML:DB Examples, derived from the eXist documentation
 * <a href="http://exist.sourceforge.net/devguide_xmldb.html">
 * http://exist.sourceforge.net/devguide_xmldb.html</a>
 * from Wolfgang M. Meier
 *
 * @author Workgroup DBIS, University of Konstanz 2005-10, ISC License
 * @author BaseX Team
 */
public abstract class Main {
  /** Database Driver. */
  static final String DRIVER = "org.basex.api.xmldb.BXDatabase";
  /** Database URL. */
  static final String URI = "xmldb:basex://localhost:1984/input";

  /** Private constructor. */
  protected Main() { }
}
