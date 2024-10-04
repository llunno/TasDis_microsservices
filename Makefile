# Run skaffold dev with necessary flags
skaffold-dev:
	skaffold dev --trigger=manual --skip-tests=true --wait-for-connection=true
skaffold-debug:
	skaffold debug --auto-sync --trigger=manual

.PHONY: skaffold-dev skaffold-debug