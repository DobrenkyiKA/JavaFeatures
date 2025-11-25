JEP 472: Prepare to Restrict the Use of JNI — quick interview notes

What it is
- A JDK 24 initiative to begin tightening how JNI (Java Native Interface) can bypass Java’s safety guarantees. JDK 24 itself does not break existing JNI code, but it adds guidance/diagnostics and sets the stage for future restrictions and safer defaults.

Why it matters
- JNI can pierce encapsulation (read/write private fields, call non‑public methods, define classes, etc.), which is risky for security, maintainability, and platform integrity.
- The platform now offers safer alternatives for most native interop scenarios (notably the Foreign Function & Memory API), so the JDK is moving toward limiting “anything goes” native access.

What changes in JDK 24
- No hard restriction yet; expect diagnostics/documentation to help identify integrity‑sensitive JNI usage.
- Clarifies direction: integrity‑sensitive JNI operations may require explicit opt‑ins in the future, and unsupported/internal access will be reduced.

What’s likely next (future releases)
- Gradual shift to “deny by default” for sensitive JNI operations unless explicitly enabled by the user/deployer.
- Stronger boundaries so that privileged native access requires clear consent (e.g., command‑line flags), nudging libraries/tools toward supported, safer APIs.

Who is affected
- Libraries and apps that use JNI to:
  - Access non‑public members across packages/modules.
  - Define/manipulate classes or otherwise depend on VM/JDK internals.
  - Perform deep reflection‑like access via native code.
- Tooling that historically used JNI “superpowers” for profiling/instrumentation — consider JVMTI, JFR, MethodHandles, or the Foreign Function & Memory (FFM) API where appropriate.

How to prepare (practical steps)
- Audit native code paths on JDK 24; pay attention to any new warnings/notes around JNI usage.
- Prefer FFM (java.lang.foreign) for calling C libraries and managing native memory; use jextract to generate bindings when possible.
- Avoid JNI access to non‑public members:
  - Expose needed APIs publicly or via proper module exports, or
  - Use MethodHandles with legitimate access, or
  - Redesign to remove the need for privileged native access.
- Stop relying on JDK internals; stick to supported, documented APIs.

Interview one‑liner
- “JEP 472 starts the transition to restrict JNI’s ability to break Java’s encapsulation. JDK 24 adds diagnostics and guidance now, with stricter, opt‑in controls coming later. Migrate toward safer alternatives like the Foreign Function & Memory API.”

Reference
- Official JEP: https://openjdk.org/jeps/472