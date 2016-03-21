(ns ingest
  (:use     [streamparse.specs])
  (:gen-class))

(defn ingest [options]
   [
    ;; spout configuration
    {"udp-spout" (python-spout-spec
          options
          "spouts.udpspout.UdpSpout"
          {
          	;;streams to output
          	"orig" ["orig"]
          }
          :conf {
                 "ingest.spouts.udpspout.emitStream","orig"
                 }
          )
	}
    ;; bolt configuration
    {

    "anchor-bolt" (python-bolt-spec
	     options
	     {["udp-spout" "orig"]["orig"]}
	     "bolts.anchor.Anchor"
	     {
	     "orig" ["orig"]
	     }
	     :p 1
	     :conf {
	            "ingest.bolts.anchor.emitStream","orig"
	            "ingest.bolts.anchor.id","uuid"
	            }
	     ),
     "iptodot-bolt" (python-bolt-spec
          options
          {["anchor-bolt" "orig"]["orig"]}
          "bolts.iptodot.IpToDot"
          {
          "orig" ["orig"]
          }
          :p 1
          :conf {"ingest.iptodot.fields","{'transform':{'src_addr':'src_dot','dst_addr':'dst_dot'}}"
          		"ingest.iptodot.emitStream","orig"
          		}
          ),
     "hilbert-bolt" (python-bolt-spec
          options
          {["iptodot-bolt" "orig"]["orig"]}
          "bolts.hilbert.HilbertBolt"
          {
          "orig" ["orig"]
          }
          :p 1
          :conf {
          		"ingest.hilbert.fields","{'id':'uuid','src':'src_addr','dst':'dst_addr'}"
          		"ingest.hilbert.emitStream","orig"
          		}
          ),
    "img-bolt" (python-bolt-spec
	     options
	     {["hilbert-bolt" "orig"]["orig"]}
	     "bolts.pngmaker.PngMaker"
	     {
	     "orig" ["orig"]
	     }
	     :p 1
	     :conf {
	            "ingest.bolts.pngmaker.emitStream","orig"
	            "ingest.bolts.pngmaker.id","uuid"
	            "topology.tick.tuple.freq.secs",30
	            }
	     ),
    }
  ]
)
