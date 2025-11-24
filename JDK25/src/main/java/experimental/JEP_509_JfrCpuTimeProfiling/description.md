# JFR CPU-Time Profiling (JEP 509 – Experimental)
JEP 509 adds CPU-time-based profiling support to Java Flight Recorder (JFR). This feature enables us to record and analyze the amount of CPU time spent in specific methods or threads, thereby improving performance diagnostics, particularly in multi-threaded and I/O-bound workloads. Use the new JDK.CPULoad and related JFR events with custom recordings:

>-XX:StartFlightRecording=filename=cpu-time.jfr,duration=10s,settings=profile
--enable-preview

Then analyze the CPU time.JFR file in JDK Mission Control or VisualVM to observe CPU usage per method and thread.