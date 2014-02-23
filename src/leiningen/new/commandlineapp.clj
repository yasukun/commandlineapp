(ns leiningen.new.commandlineapp
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "commandlineapp"))

(defn commandlineapp
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (->files data
             [".gitignore"  (render "gitignore")]
             ["project.clj" (render "project.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)])))
