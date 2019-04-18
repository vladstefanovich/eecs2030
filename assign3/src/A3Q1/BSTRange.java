package A3Q1;

/**
 * Extends the TreeMap class to allow convenient access to entries within a
 * specified range of key values (findAllInRange).
 * 
 * @author jameselder
 */
public class BSTRange<K, V> extends TreeMap<K, V> {

	/*
	 * Returns the lowest (deepest) position in the subtree rooted at pos that is a
	 * common ancestor to positions with keys k1 and k2, or to the positions they
	 * would occupy were they present.
	 */
	protected Position<Entry<K, V>> findLowestCommonAncestor(K k1, K k2, Position<Entry<K, V>> pos) {
		// implement this method
		if (pos == null) {
			return root();
		} else {
			if (compare(k1, pos.getElement().getKey()) == -1 && compare(k2, pos.getElement().getKey()) == 1) {
				return pos;
			} else if (right(pos) != null) {
				if (compare(k1, pos.getElement().getKey()) == 1 && compare(k2, pos.getElement().getKey()) == 1)
					return findLowestCommonAncestor(k1, k2, right(pos));
				else
					return pos;
			} else if (left(pos) != null) {
				if (compare(k1, pos.getElement().getKey()) == -1 && compare(k2, pos.getElement().getKey()) == -1)
					return findLowestCommonAncestor(k1, k2, left(pos));
				else
					return pos;
			} else {
				return root();
			}
		}
	}

	/*
	 * Finds all entries in the subtree rooted at pos with keys of k or greater and
	 * copies them to L, in non-decreasing order.
	 */
	protected void findAllAbove(K k, Position<Entry<K, V>> pos, PositionalList<Entry<K, V>> L) {
		// implement this method
		if (pos == null) {
			return;
		} else {
			if (right(pos) != null) {
				if (compare(k, pos.getElement().getKey()) != 1) {
					findAllAbove(k, right(pos), L);
					L.addFirst(pos.getElement());
				}
			}
			if (left(pos) != null)
				if (compare(k, pos.getElement().getKey()) != 1)
					findAllAbove(k, left(pos), L);
		}

	}

	/*
	 * Finds all entries in the subtree rooted at pos with keys of k or less and
	 * copies them to L, in non-decreasing order.
	 */
	protected void findAllBelow(K k, Position<Entry<K, V>> pos, PositionalList<Entry<K, V>> L) {
		// implement this method
		if (pos == null) {
			return;
		} else {
			if (left(pos) != null) {
				if (compare(k, pos.getElement().getKey()) != -1) {
					findAllBelow(k, left(pos), L);
					L.addLast(pos.getElement());
				}
			}
			if (right(pos) != null)
				if (compare(k, pos.getElement().getKey()) != -1)
					findAllBelow(k, right(pos), L);
		}
	}

	/*
	 * Returns all entries with keys no less than k1 and no greater than k2, in
	 * non-decreasing order.
	 */
	public PositionalList<Entry<K, V>> findAllInRange(K k1, K k2) {
		// implement this method
		PositionalList<Entry<K, V>> L = new LinkedPositionalList<>();
		if (this.isEmpty()) {
			return L;
		} else {
			Position<Entry<K, V>> pos = findLowestCommonAncestor(k1, k2, root());
			if (this.isEmpty()) {
				return L;
			} else if (compare(k1, k2) == 1) {
				return L;
			} else if (compare(k1, root().getElement().getKey()) == -1
					&& compare(k2, root().getElement().getKey()) == -1) {
				if (pos != null) {

				}
				return L;
			}

			else {
				if (pos != null) {
					if (compare(k1, pos.getElement().getKey()) != 1) {
						findAllAbove(k1, left(pos), L);
						L.addLast(pos.getElement());
					}
					if (compare(k2, pos.getElement().getKey()) != -1)
						findAllBelow(k2, right(pos), L);
				}
				return L;
			}
		}
	}
}
