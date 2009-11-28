package org.basex.util;

import java.util.Arrays;

/**
 * This is a simple hash map, extending the even simpler
 * {@link TokenSet hash set}.
 *
 * @author Workgroup DBIS, University of Konstanz 2005-09, ISC License
 * @author Christian Gruen
 */
public final class TokenMap extends TokenSet {
  /** Hash values. */
  private byte[][] values = new byte[CAP][];

  /**
   * Indexes the specified keys and values.
   * @param key key
   * @param val value
   */
  public void add(final byte[] key, final byte[] val) {
    // array bounds are checked before array is resized..
    final int i = add(key);
    values[i] = val;
  }

  /**
   * Returns the value for the specified key.
   * @param key key to be found
   * @return value or null if nothing was found
   */
  public byte[] get(final byte[] key) {
    return key != null ? values[id(key)] : null;
  }

  /**
   * Returns the specified value.
   * @param p value index
   * @return value
   */
  public byte[] value(final int p) {
    return values[p];
  }

  @Override
  protected void rehash() {
    super.rehash();
    values = Arrays.copyOf(values, size << 1);
  }
}
