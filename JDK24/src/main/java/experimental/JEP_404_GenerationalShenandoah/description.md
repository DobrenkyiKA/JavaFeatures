JEP 404: Generational Shenandoah — short summary

Overview
- Introduces a generational mode for the Shenandoah GC by splitting the heap into young and old generations.
- Collects young objects frequently and old objects less often to reduce copying of long‑lived objects while preserving Shenandoah’s low pause times.

Goals and motivation
- Improve throughput and decrease memory traffic versus non‑generational Shenandoah.
- Keep pause times short and predictable for latency‑sensitive applications.

Key changes
- Regioned heap organized into two generations with tracking of inter‑generational references.
- Young‑only collections handle most short‑lived allocations; mixed/old collections are rarer.
- Adjusted barriers and remembered sets/card tables to maintain correctness between generations.

Benefits
- Fewer evacuations of long‑lived objects, better cache locality, and improved throughput.
- Lower average and tail latencies with more predictable GC behavior.

Status and usage
- Delivered as a new mode of Shenandoah and initially opt‑in via JVM flags (experimental at introduction). Check your JDK’s help for exact options.

Reference
- Official JEP: https://openjdk.org/jeps/404