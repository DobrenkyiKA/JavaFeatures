JEP 450: Compact Object Headers (Experimental) — quick interview notes

What it is
- An experimental HotSpot VM feature that shrinks Java object headers to reduce memory footprint and improve cache locality. Targeted at 64‑bit platforms in JDK 24.

Why it matters
- Typical Java heaps are dominated by small objects; cutting header size can save double‑digit percentages of heap space in many workloads.
- Better memory density → fewer cache misses → potential throughput/latency wins without changing application code.

How it works (high level)
- The classic header stores multiple pieces of metadata (e.g., mark bits, identity hash, lock state, class pointer/metadata).
- Compact Headers redesign this so the common, “cold” or infrequent parts (like inflated monitor state or identity hash) are moved out of the object and stored only when actually needed.
- The frequently used bits stay in a compact mark word; the class metadata is represented more compactly and/or indirectly, keeping the per‑object header small on the fast path.

When it helps vs. when it might hurt
- Helps: object‑heavy workloads with many small objects and little locking/hashing; memory‑bound or cache‑sensitive applications.
- May have overhead: code that heavily relies on synchronized blocks with monitor inflation or that frequently calls Object::hashCode on many distinct objects, because rare metadata is materialized off the fast path.

Compatibility
- Transparent to Java code: no changes to class files, language, or libraries required.
- Some low‑level tooling/assumptions about header layout can be affected; rely on supported APIs (Unsafe/VarHandle/SA tools) rather than hard‑coded header sizes.

How to try it in JDK 24
- This is off by default and marked experimental.
- Enable with JVM flags: -XX:+UnlockExperimentalVMOptions -XX:+UseCompactObjectHeaders

Interview one‑liner
- “JEP 450 compacts HotSpot object headers so the common case stays small and rarely used metadata is stored on demand, reducing heap footprint and improving cache behavior; it’s experimental in JDK 24 and enabled with -XX:+UseCompactObjectHeaders.”

Reference
- Official JEP: https://openjdk.org/jeps/450