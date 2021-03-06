# Key References #

[Delphor Website](http://www.delphor.net/) 

[Delphor Wiki](https://github.com/delphornet/Cortextual/wiki) 

[Main Project README, including licensing and resources](https://github.com/delphornet/Cortextual/blob/master/README.md)

# Delphor/Ingest Project Managers #

Currently led by Rob Weiss (@3XPlo1t2) and John Eberhardt (@JohnSEberhardt3).

# Delphor/Ingest Project Roadmap #

The roadmap for this project is [here.](https://github.com/delphornet/Cortextual/wiki/Project-Roadmap#delphoringest-repo-and-project-roadmap)

# Features, Functional Requirements, and Components in this Repo #

+	Feature DI1: Ingest Delphor/Sense data 
	+	Functional Requirement DI1A: unpack netflow
		+	Component DI1Ai: unpack netflow V5
			+	**Status: complete**
+	Feature DI2: Organize ingested data into arrays for analysis 
	+	Functional Requirement DI2A: create arrays for analysis of netflow
		+	Component DI2Ai: Array 0: Basic Flow Counts
			+	**Status: complete**
		+ Component DI2Aii: Array 1: Destination Port Counts, by flows and bytes
			+ **Status: complete**
		+ Component DI2Aiii: Array 2: Source Port Counts, by flows and bytes
			+ **Status: complete**
		+	Component DI2Aiv: Array 3:Destination IP Counts, by flows and bytes
			+	**Status: complete**

If you want to add to the roadmap, learn more [here.](https://github.com/delphornet/Cortextual/wiki/Feature-and-Release-Management)

# What's Here #

This is the streaming ingest of data for the Cortextual Project. This process is built using [Streamparse](https://github.com/Parsely/streamparse). Currently there is one topology, ingest, which takes network data in the form of [Netflow V5](https://www.plixer.com/support/netflow_v5.html). 

The topology creates videos which show the result of the analytics plotted on a [Hilbert Space Filling Curve](https://en.wikipedia.org/wiki/Hilbert_curve).

# Contributors #

Rob Weiss (@3XPlo1t2)
