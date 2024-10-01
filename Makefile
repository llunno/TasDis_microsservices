# Run skaffold dev with necessary flags
skaffold-dev:
	skaffold dev --trigger=manual --skip-tests=true --wait-for-connection=true

.PHONY: skaffold-dev