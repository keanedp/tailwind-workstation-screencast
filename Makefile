.PHONY: dev css-once css-watch

dev:
	@echo "Running development environment"
	clojure -A:fig:build

clean:
	@echo "Cleaning target"
	rm -rf target/public

pom.xml:
	@echo "Generating pom file"
	clojure -Spom

css-once:
	@echo "Compiling CSS"
	./node_modules/.bin/postcss resources/css/tailwind.css -o resources/public/css/tailwind.css

css-watch:
	@echo "Watching CSS"
	./node_modules/.bin/postcss -w --verbose resources/css/tailwind.css -o resources/public/css/styles.css
